package br.com.mind5.masterData.bankSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.bankSearch.info.BankarchInfo;
import br.com.mind5.masterData.bankSearch.model.action.BankarchVisiDaoSelect;
import br.com.mind5.masterData.bankSearch.model.action.BankarchVisiMergeCountry;
import br.com.mind5.masterData.bankSearch.model.checker.BankarchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankarchRootSelect extends DeciTreeTemplateRead<BankarchInfo> {
	
	public BankarchRootSelect(DeciTreeOption<BankarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankarchInfo> buildCheckerHook(DeciTreeOption<BankarchInfo> option) {
		List<ModelChecker<BankarchInfo>> queue = new ArrayList<>();		
		ModelChecker<BankarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BankarchInfo>> buildActionsOnPassedHook(DeciTreeOption<BankarchInfo> option) {
		List<ActionStd<BankarchInfo>> actions = new ArrayList<>();
		
		ActionStd<BankarchInfo> select = new ActionStdCommom<BankarchInfo>(option, BankarchVisiDaoSelect.class);
		ActionLazy<BankarchInfo> mergeContry = new ActionLazyCommom<BankarchInfo>(option, BankarchVisiMergeCountry.class);
		
		select.addPostAction(mergeContry);
		
		actions.add(select);
		return actions;
	}
}
