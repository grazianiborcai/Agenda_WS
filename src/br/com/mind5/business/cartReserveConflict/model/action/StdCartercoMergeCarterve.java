package br.com.mind5.business.cartReserveConflict.model.action;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartercoMergeCarterve extends ActionStdTemplate<CartercoInfo> {

	public StdCartercoMergeCarterve(DeciTreeOption<CartercoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CartercoInfo> buildVisitorHook(DeciTreeOption<CartercoInfo> option) {
		return new VisiCartercoMergeCarterve(option);
	}
}
