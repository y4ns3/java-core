package lessons.lesson05.EducationalCenter;

import java.util.ArrayList;
import java.util.List;

public class Attendance {

        private List<Boolean> records = new ArrayList<>();

        public void addRecord(boolean isPresent) {
            records.add(isPresent);
        }

        public String getSummary() {
            long presentCount = records.stream().filter(r -> r).count();
            return presentCount + "/" + records.size() + " presence";
        }
}


