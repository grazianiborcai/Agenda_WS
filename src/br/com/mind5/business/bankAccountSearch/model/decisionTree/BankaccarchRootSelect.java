package br.com.mind5.business.bankAccountSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.business.bankAccountSearch.model.action.BankaccarchVisiMergeToSelect;
import br.com.mind5.business.bankAccountSearch.model.checker.BankaccarchCheckLangu;
import br.com.mind5.business.bankAccountSearch.model.checker.BankaccarchCheckOwner;
import br.com.mind5.business.bankAccountSearch.model.checker.BankaccarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankaccarchRootSelect extends DeciTreeTemplateRead<BankaccarchInfo> {
	
	public BankaccarchRootSelect(DeciTreeOption<BankaccarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankaccarchInfo> buildCheckerHook(DeciTreeOption<BankaccarchInfo> option) {
		List<ModelChecker<BankaccarchInfo>> queue = new ArrayList<>();		
		ModelChecker<BankaccarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankaccarchCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new BankaccarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BankaccarchInfo>> buildActionsOnPassedHook(DeciTreeOption<BankaccarchInfo> option) {
		List<ActionStd<BankaccarchInfo>> actions = new ArrayList<>();
		
		ActionStd<BankaccarchInfo> select = new ActionStdCommom<BankaccarchInfo>(option, BankaccarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
