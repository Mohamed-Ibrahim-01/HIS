package src.validation;

import src.management.*;

public class ValidInput {
    public static boolean isExistSysMed(String name) {
        if (StoreManage.medicationStorage.containsKey(name)) {
            return true;
        } else
            return false;

    }
}
