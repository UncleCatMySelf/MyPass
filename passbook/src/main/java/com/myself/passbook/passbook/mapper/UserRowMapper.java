package com.myself.passbook.passbook.mapper;


import com.myself.passbook.passbook.constant.Constants;
import com.myself.passbook.passbook.vo.User;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * <h1>HBase User Row To User Object</h1>
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:35 2018\8\23 0023
 */
public class UserRowMapper implements RowMapper<User> {

    //获取字节数组
    private static byte[] FAMILY_B = Constants.UserTable.FAMTLY_B.getBytes();
    private static byte[] NAME = Constants.UserTable.NAME.getBytes();
    private static byte[] AGE = Constants.UserTable.AGE.getBytes();
    private static byte[] SEX = Constants.UserTable.SEX.getBytes();

    private static byte[] FAMILY_O = Constants.UserTable.FAMILY_O.getBytes();
    private static byte[] PHONE = Constants.UserTable.PHONE.getBytes();
    private static byte[] ADDRESS = Constants.UserTable.ADDRESS.getBytes();


    @Override
    public User mapRow(Result result, int i) throws Exception {

        User.BaseInfo baseInfo = new User.BaseInfo(
                Bytes.toString(result.getValue(FAMILY_B,NAME)),
                Bytes.toInt(result.getValue(FAMILY_B,AGE)),
                Bytes.toString(result.getValue(FAMILY_B,SEX))
        );

        User.OtherInfo otherInfo = new User.OtherInfo(
                Bytes.toString(result.getValue(FAMILY_O,PHONE)),
                Bytes.toString(result.getValue(FAMILY_O,ADDRESS))
        );

        return new User(
                Bytes.toLong(result.getRow()),baseInfo,otherInfo
        );
    }
}
