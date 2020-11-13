package br.com.mind5.payment.countryPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.action.LazyCounparMergePaypar;
import br.com.mind5.payment.countryPartner.model.action.StdCounparDaoSelect;
import br.com.mind5.payment.countryPartner.model.checker.CounparCheckRead;

public final class RootCounparSelect extends DeciTreeTemplateRead<CounparInfo> {
	
	public RootCounparSelect(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CounparInfo> buildCheckerHook(DeciTreeOption<CounparInfo> option) {
		List<ModelChecker<CounparInfo>> queue = new ArrayList<>();		
		ModelChecker<CounparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CounparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CounparInfo>> buildActionsOnPassedHook(DeciTreeOption<CounparInfo> option) {
		List<ActionStd<CounparInfo>> actions = new ArrayList<>();
		
		ActionStd<CounparInfo> select = new StdCounparDaoSelect(option);
		ActionLazy<CounparInfo> mergePayPartner = new LazyCounparMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
