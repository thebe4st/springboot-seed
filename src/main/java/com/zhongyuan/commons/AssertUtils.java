package com.zhongyuan.commons;

import cn.hutool.core.util.StrUtil;
import com.zhongyuan.exception.ServiceException;
import com.zhongyuan.exception.ResultCodes;

import java.util.Objects;

public class AssertUtils {

    public static void assertNotNull(Object o, ResultCodes resultCodes) {
        if (Objects.isNull(o)) {
            throw new ServiceException(resultCodes);
        }
        if (o instanceof String) {
            if (StrUtil.isBlank((String) o)) {
                throw new ServiceException(resultCodes);
            }
        }
    }

    public static void assertIsTrue(boolean b, ResultCodes resultCodes) {
        if (!b) {
            throw new ServiceException(resultCodes);
        }
    }
}
