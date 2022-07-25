package br.com.mind5.masterData.materialSubgroup.model.action;

import java.util.List;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.decisionTree.MatubupRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatubupVisiRootSelect extends ActionVisitorTemplateAction<MatubupInfo, MatubupInfo> {

	public MatubupVisiRootSelect(DeciTreeOption<MatubupInfo> option) {
		super(option, MatubupInfo.class, MatubupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatubupInfo>> getTreeClassHook() {
		return MatubupRootSelect.class;
	}
	
	
	
	@Override protected List<MatubupInfo> toBaseClassHook(List<MatubupInfo> baseInfos, List<MatubupInfo> results) {
		return results;
	}
}
