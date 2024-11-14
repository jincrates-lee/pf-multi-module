package me.jincrates.pf.common.utils;

import java.security.SecureRandom;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class IdGenerator {

    // 영문자와 숫자로 구성된 문자열
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    private static final Random RANDOM = new SecureRandom();

    public static String generateId(String prefix) {
        return prefix + UUID.randomUUID();
    }

    /**
     * 아이디 생성 규칙: timestamp(17자리) + random number(3자리)
     */
    public static String generateRandomId() {
        String timestamp = DateUtil.getCurrentDateTime().format(DATE_TIME_FORMATTER);
        String random = String.format(
            "%03d",
            RANDOM.nextInt(1000)
        );
        return timestamp + random;
    }
}
