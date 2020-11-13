package br.com.mind5.geo.geoHash.model.action;

import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGeoshGenerate extends ActionStdTemplate<GeoshInfo> {

	public StdGeoshGenerate(DeciTreeOption<GeoshInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<GeoshInfo> buildVisitorHook(DeciTreeOption<GeoshInfo> option) {
		return new VisiGeoshGenerate(option);
	}
}
