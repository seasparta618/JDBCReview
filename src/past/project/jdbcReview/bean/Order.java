package past.project.jdbcReview.bean;

/**
 * Past project knowledge review
 * 
 * @author Sparta
 *
 */

public class Order {

	private Integer id;
	private Integer userId;
	private String productNumber;
	private String createTime;
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", productNumber=" + productNumber + ", createTime="
				+ createTime + ", note=" + note + "]";
	}

}
