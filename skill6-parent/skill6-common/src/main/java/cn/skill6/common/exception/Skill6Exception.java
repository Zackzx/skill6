package cn.skill6.common.exception;

/**
 * @Desc skill6系统异常基类
 *
 * @Author 何明胜
 *
 * @Created at 2018年2月26日 下午11:58:54
 * 
 * @Version 1.0.1
 */
public class Skill6Exception extends RuntimeException {
	private static final long serialVersionUID = 7462624691843766045L;
	
	/** 错误编码 */
	private int errorCode;

	public Skill6Exception() {
		super();
	}

	/* ----------------------- added constructors ---------------------------*/
	
	/**
	 * @param errorCode
	 * @param cause
	 */
	public Skill6Exception(int errorCode,Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param errorCode
	 * @param message
	 */
	public Skill6Exception(int errorCode,String message) {
		super(message);
	}
	
	/**
	 * @param errorCode
	 * @param message
	 * @param cause
	 */
	public Skill6Exception(int errorCode,String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * @param errorCode
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public Skill6Exception(int errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/* ----------------------- origin constructors ---------------------------*/
	
	/**
	 * @param cause
	 */
	public Skill6Exception(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public Skill6Exception(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public Skill6Exception(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public Skill6Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/* ----------------------- setter/getter ---------------------------*/
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}