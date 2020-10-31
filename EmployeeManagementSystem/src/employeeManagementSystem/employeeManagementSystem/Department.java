package employeeManagementSystem;

// Enum som representerar dem olika Departments som finns.
// toString funktion för att kunna skriva ut dem snyggt
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