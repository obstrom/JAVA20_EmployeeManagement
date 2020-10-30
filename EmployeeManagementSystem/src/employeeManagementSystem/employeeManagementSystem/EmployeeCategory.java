package employeeManagementSystem;

public enum EmployeeCategory {
    MANAGER {
        @Override
        public String toString() {
            return "Manager";
        }
    },
    PROGRAMMER {
        @Override
        public String toString() {
            return "Programmer";
        }
    },
    SECRETARY {
        @Override
        public String toString() {
            return "Secretary";
        }
    },
    TECHNICIAN {
        @Override
        public String toString() {
            return "Technician";
        }
    };
}