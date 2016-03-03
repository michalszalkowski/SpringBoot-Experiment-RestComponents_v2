package pl.btbw.core.common.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentProvider {

	private Mappable entity;

	public List<Component> components = new ArrayList<>();
	public Map<String, Component> componentMap = new HashMap<>();

	public ComponentProvider(Mappable entity) {
		this.entity = entity;
	}

	public ComponentProvider add(Component component) {
		component.map(entity);
		components.add(component);
		componentMap.put(component.getNameComponent(), component);
		return this;
	}

	public Component buildOne() {
		return components.get(0);
	}

	public List<Component> buildList() {
		return components;
	}

	public Map<String, Component> buildMap() {
		return componentMap;
	}
}
