package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.CartemNodeAged;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemVisiNodeAged extends ActionVisitorTemplateAction<CartemInfo, CartemInfo> {

	public CartemVisiNodeAged(DeciTreeOption<CartemInfo> option) {
		super(option, CartemInfo.class, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemInfo>> getTreeClassHook() {
		return CartemNodeAged.class;
	}
	
	
	
	@Override protected List<CartemInfo> toBaseClassHook(List<CartemInfo> baseInfos, List<CartemInfo> results) {
		return results;
	}
}
