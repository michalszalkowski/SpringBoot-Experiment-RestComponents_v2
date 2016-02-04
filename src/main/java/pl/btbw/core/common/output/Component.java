package pl.btbw.core.common.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Component {

	@JsonProperty(value = "_nameComponent")
	String getNameComponent();

	void map(Mappable mappable);
}
