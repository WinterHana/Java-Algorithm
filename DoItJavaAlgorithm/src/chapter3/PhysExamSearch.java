package chapter3;

public class PhysExamSearch {
    static class PhyscData {
        private String  name;
        private int     height;
        private double  vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }
    }
}
