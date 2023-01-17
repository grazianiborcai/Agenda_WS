package br.com.mind5.masterData.bankAccountType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.masterData.bankAccountType.model.action.BankacypeVisiDaoSelect;
import br.com.mind5.masterData.bankAccountType.model.checker.BankacypeCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class BankacypeRootSelect extends DeciTreeTemplateRead<BankacypeInfo> {
	
	public BankacypeRootSelect(DeciTreeOption<BankacypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BankacypeInfo> buildCheckerHook(DeciTreeOption<BankacypeInfo> option) {
		List<ModelChecker<BankacypeInfo>> queue = new ArrayList<>();		
		ModelChecker<BankacypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new BankacypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<BankacypeInfo>> buildActionsOnPassedHook(DeciTreeOption<BankacypeInfo> option) {
		List<ActionStd<BankacypeInfo>> actions = new ArrayList<>();
		
		ActionStd<BankacypeInfo> select = new ActionStdCommom<BankacypeInfo>(option, BankacypeVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
