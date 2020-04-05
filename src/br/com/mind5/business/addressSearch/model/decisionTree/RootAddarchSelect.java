package br.com.mind5.business.addressSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.action.StdAddarchMergeToSelect;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckLangu;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootAddarchSelect extends DeciTreeWriteTemplate<AddarchInfo> {
	
	public RootAddarchSelect(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddarchInfo> buildCheckerHook(DeciTreeOption<AddarchInfo> option) {
		List<ModelChecker<AddarchInfo>> queue = new ArrayList<>();		
		ModelChecker<AddarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AddarchInfo>> buildActionsOnPassedHook(DeciTreeOption<AddarchInfo> option) {
		List<ActionStdV1<AddarchInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<AddarchInfo> select = new StdAddarchMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}
