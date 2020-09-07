package top.tjq.common.enumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Create by moling_tjq on 2020-09-04
 */
@AllArgsConstructor
@Getter
public enum PackageType {
    REQUEST_PACK(0),
    RESPONSE_PACK(1);

    private final int code;
}
