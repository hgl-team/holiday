package org.hgl.service.holiday.infrastructure.jpa;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class DataSourceInformation implements Serializable {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String jndiName;
    private boolean isJndi;

    @Override
    public String toString() {
        return "DataSourceInformation{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
