package ru.cs.ifmo.utils;

import javax.ejb.Stateless;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Stateless
public class PasswordEncryptor {

	public String encrypt(final String password){

		String encrypted = null;
		byte[] mdbytes;
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}

		if (md != null){
			mdbytes = md.digest();

			StringBuilder sb = new StringBuilder();

			for (byte mdbyte : mdbytes) {
				String s = Integer.toHexString(0xff & mdbyte);
				s = (s.length() == 1) ? "0" + s : s;
				sb.append(s);
			}

			encrypted = sb.toString();
		}

		return encrypted;
	}

}
