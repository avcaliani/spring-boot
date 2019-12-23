package br.avcaliani.skeleton.util;

import java.io.Serializable;

public final class Messages implements Serializable {

    public static final String NULL_TASK_ENTITY = "Null Task Entity.";
    public static final String NULL_TASK_DTO = "Null Task DTO.";
    public static final String NULL_TASK = "Null Task.";

    public static final String TASK_ID_IS_NULL = "Task Id Null!";
    public static final String TASK_DESCRIPTION_IS_NULL = "Task description Id Null!";
    public static final String TASK_OWNER_IS_NULL = "Task Id owner Null!";

    public static final String SUB_TASK_IS_NULL = "Sub-Task Id Null!";
    public static final String SUB_TASK_DESCRIPTION_IS_NULL = "Sub-Task Id Null!";

    public static final String NULL_PARAM = "Null Parameter.";

    public static final String NULL_SUB_TASK_ENTITY = "Null Sub Task Entity.";
    public static final String NULL_SUB_TASK_DTO = "Null Sub Task DTO.";

    private Messages() { /* Avoiding new instances */ }

}
