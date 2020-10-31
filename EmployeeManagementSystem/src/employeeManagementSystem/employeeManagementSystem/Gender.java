package employeeManagementSystem;

// Enum som representerar dem olika Departments som finns.
// toString funktion för att kunna skriva ut dem snyggt
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
