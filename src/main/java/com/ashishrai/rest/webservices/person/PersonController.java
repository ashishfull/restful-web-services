package com.ashishrai.rest.webservices.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashishrai.rest.webservices.person.records.Name;
import com.ashishrai.rest.webservices.person.records.PersonV1;
import com.ashishrai.rest.webservices.person.records.PersonV2;

// Implementing REST API Versioning
@RestController
public class PersonController {

	// URI versioning v1
	@GetMapping("/v1/person")
	public PersonV1 getPersonVersion1() {
		return new PersonV1("Ashish Rai");
	}

	// URI versioning v2
	@GetMapping("/v2/person")
	public PersonV2 getPersonVersion2() {
		return new PersonV2(new Name("Ashish", "Rai"));
	}

	// Request Parameter versioning v1
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getPersonRequestParamVersion1() {
		return new PersonV1("Ashish Rai");
	}

	// Request Parameter versioning v2
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getPersonRequestParamVersion2() {
		return new PersonV2(new Name("Ashish", "Rai"));
	}

	// Request Header versioning v1
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getPersonRequestHeaderVersion1() {
		return new PersonV1("Ashish Rai");
	}

	// Request Header versioning v2
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getPersonRequestHeaderVersion2() {
		return new PersonV2(new Name("Ashish", "Rai"));
	}

	// Media Type versioning v1
	@GetMapping(path = "/person/header", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getPersonMediaTypeVersion1() {
		return new PersonV1("Ashish Rai");
	}

	// Media Type versioning v2
	@GetMapping(path = "/person/header", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getPersonMediaTypeVersion2() {
		return new PersonV2(new Name("Ashish", "Rai"));
	}
}
