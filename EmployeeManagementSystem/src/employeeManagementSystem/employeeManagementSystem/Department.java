package employeeManagementSystem;

public enum Department {
    IT {
        @Override
        public String toString() {
            return "IT";
        }
    },
    ECONOMY {
        @Override
        public String toString() {
            return "Economy";
        }
    },
    MARKETING {
        @Override
        public String toString() {
            return "Marketing";
        }
    },
    HR {
        @Override
        public String toString() {
            return "HR";
        }
    },
    MANAGEMENT {
        @Override
        public String toString() {
            return "Management";
        }
    };
}