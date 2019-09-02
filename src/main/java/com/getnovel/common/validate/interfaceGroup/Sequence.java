package com.getnovel.common.validate.interfaceGroup;

import javax.validation.GroupSequence;

/**
 *校验组序列 按照先校验BeforeRegexp后验证Insert组的顺序
 * BeforeRegexp校验不通过则不进行Insert组的校验
 */
@GroupSequence({BeforeRegexp.class,Insert.class})
public interface Sequence {
}
