package org.example;

public class Enrollee {
        private String lastName;
        private int points;

        public  Enrollee (String lastName, int points) {
            this.lastName = lastName;
            this.points = points;
        }

        public String getLastName() {
            return lastName;
        }

        public int getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return lastName + ": " + points;
        }
}

