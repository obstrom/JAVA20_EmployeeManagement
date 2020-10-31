package employeeManagementSystem;

// Enum som representerar dem olika Categories av Employee som finns för menyval.
// toString funktion för att kunna skriva ut dem snyggt
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