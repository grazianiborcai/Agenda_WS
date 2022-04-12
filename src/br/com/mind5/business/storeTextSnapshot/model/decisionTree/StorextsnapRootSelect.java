package br.com.mind5.business.storeTextSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.business.storeTextSnapshot.model.action.StorextsnapVisiMergeToSelect;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckOwner;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckRead;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckStorext;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorextsnapRootSelect extends DeciTreeTemplateRead<StorextsnapInfo> {
	
	public StorextsnapRootSelect(DeciTreeOption<StorextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextsnapInfo> buildCheckerHook(DeciTreeOption<StorextsnapInfo> option) {
		List<ModelChecker<StorextsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckStorext(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextsnapInfo> option) {
		List<ActionStd<StorextsnapInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextsnapInfo> select = new ActionStdCommom<StorextsnapInfo>(option, StorextsnapVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
