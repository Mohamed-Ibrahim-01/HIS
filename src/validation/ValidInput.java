package src.validation;

import src.management.*;

public class ValidInput {
    public static boolean isExistSysMed(String name) {
        return StoreManage.medicationStorage.containsKey(name); 
    }
}
