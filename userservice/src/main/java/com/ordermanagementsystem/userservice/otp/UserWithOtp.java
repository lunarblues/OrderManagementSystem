package com.ordermanagementsystem.userservice.otp;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import com.ordermanagementsystem.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class UserWithOtp implements Portable {

    public static final int CLASS_ID = 1;
    public static final int FACTORY_ID = 1;

    private String otp;
    private UserDTO userDTO;

    public UserWithOtp() {}

    public UserWithOtp(String otp, UserDTO userDTO) {
        this.otp = otp;
        this.userDTO = userDTO;
    }

    @Override
    public int getFactoryId() {
        return FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeUTF("otp", otp);

        writer.writeInt("userId", userDTO.getUserId());
        writer.writeUTF("username", userDTO.getUsername());
        writer.writeUTF("password", userDTO.getPassword());
        writer.writeUTF("email", userDTO.getEmail());
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        this.otp = reader.readUTF("otp");

        this.userDTO = new UserDTO(
                reader.readInt("userId"),
                reader.readUTF("username"),
                reader.readUTF("password"),
                reader.readUTF("email")
        );
    }

}
