package com.busraciftlik.common.util.constants;

public class Messages {
    public static class Car {
        public static final String notExists = "CAR_NOT_EXISTS";
        public static final String exists = "CAR_ALREADY_EXISTS";
        public static final String carNotAvailable = "CAR_NOT_AVAILABLE";
    }

    public static class Model{
        public static final String notExists = "MODEL_NOT_EXISTS";
        public static final String exists = "MODEL_ALREADY_EXISTS";

    }

    public static class Brand{
        public static final String notExists = "BRAND_NOT_EXISTS";
        public static final String exists = "BRAND_ALREADY_EXISTS";
    }

    public static class Maintenance{
        public static final String notExists = "MAINTENANCE_NOT_EXISTS";
        public static final String carExists = "CAR_IS_CURRENTLY_UNDER_MAINTENANCE";
        public static final String carNotExists = "CAR_NOT_REGISTERED_FOR_MAINTENANCE";
        public static final String carIsRented = "CAR_IS_CURRENTLY_AND_CANNOT_BE_SERVICED_FOR_MAINTENANCE";
    }

    public static class Rental{
        public static final String notExists = "RENTAL_NOT_EXISTS";

    }

    public static class Payment{
        public static final String notFound = "PAYMENT_NOT_FOUND";
        public static final String cardNumberAlreadyExists = "CARD_NUMBER_ALREADY_EXISTS";
        public static final String notEnoughMoney = "NOT_ENOUGH_MONEY";
        public static final String notAValidPayment = "NOT_A_VALID_PAYMENT";
        public static final String failed= "FAILED_PAYMENT";

    }
    public static class Invoice{
        public static final String notFound = "INVOICE_NOT_FOUND";

    }
}
