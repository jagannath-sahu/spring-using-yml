package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("acme")
public class ApplicationProps {

    private List<Map<String, Object>> props;

	private List<User> users;

    public List<Map<String, Object>> getProps() {
		return props;
	}

	public void setProps(List<Map<String, Object>> props) {
		this.props = props;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

    public static class User {

    	private String username;

        private String password;

        private List<String> roles;

        public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<String> getRoles() {
			return roles;
		}

		public void setRoles(List<String> roles) {
			this.roles = roles;
		}

		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + ", roles=" + roles + "]";
		}
    }

	@Override
	public String toString() {
		return "ApplicationProps [props=" + props + ", users=" + users + "]";
	}

}