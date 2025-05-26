package airport.controller.impl;

public class InputValidator {

    public boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isLong(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Long.parseLong(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int parseInt(String value, String fieldName) throws NumberFormatException {
        if (!isNumeric(value)) {
            throw new NumberFormatException(
                    "El campo '" + fieldName + "' no contiene un número válido: '" + value + "'");
        }
        return Integer.parseInt(value.trim());
    }

    public long parseLong(String value, String fieldName) throws NumberFormatException {
        if (!isLong(value)) {
            throw new NumberFormatException(
                    "El campo '" + fieldName + "' no contiene un número válido: '" + value + "'");
        }
        return Long.parseLong(value.trim());
    }

    public double parseDouble(String value, String fieldName) throws NumberFormatException {
        if (!isDouble(value)) {
            throw new NumberFormatException(
                    "El campo '" + fieldName + "' no contiene un número válido: '" + value + "'");
        }
        return Double.parseDouble(value.trim());
    }

    public boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}