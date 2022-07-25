package br.com.mind5.masterData.materialSubgroup.model;

import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.decisionTree.MatubupRootSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatubupModelSearch extends ModelTemplate<MatubupInfo> {

	public MatubupModelSearch(MatubupInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MatubupInfo> getDecisionTreeHook(DeciTreeOption<MatubupInfo> option) {
		return new MatubupRootSearch(option);
	}
}
