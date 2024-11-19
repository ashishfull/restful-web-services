
package com.ashishrai.rest.webservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

// ignores fields mentioned in the array
// during Jackson conversion while sending API response
// @JsonIgnoreProperties({ "field1", "field2" })
@JsonFilter("SomeBeanFilter") // Dynamic filtering, specific to a rest API
public class SomeBean {

	private String field1;
	// @JsonIgnore
	// ignores this field during Jackson conversion while sending API response 
	private String field2;
	private String field3;

	public SomeBean(String field1, String field2, String field3) {

		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {

		return field1;
	}

	public String getField2() {

		return field2;
	}

	public String getField3() {

		return field3;
	}

	@Override
	public String toString() {

		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
}
