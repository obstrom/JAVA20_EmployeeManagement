package employeeManagementSystem;

public enum Gender {
    MALE {
        @Override
        public String toString() {
            return "Male";
        }
    },
    FEMALE {
        @Override
        public String toString() {
            return "Female";
        }
    },
    UNSPECIFIED {
        @Override
        public String toString() {
            return "Unspecified";
        }
    };
}
