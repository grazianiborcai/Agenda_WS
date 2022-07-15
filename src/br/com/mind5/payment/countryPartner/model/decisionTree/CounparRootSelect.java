package br.com.mind5.payment.countryPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.action.CounparVisiDaoSelect;
import br.com.mind5.payment.countryPartner.model.action.CounparVisiMergePaypar;
import br.com.mind5.payment.countryPartner.model.checker.CounparCheckRead;

public final class CounparRootSelect extends DeciTreeTemplateRead<CounparInfo> {
	
	public CounparRootSelect(DeciTreeOption<CounparInfo> option) {
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
		
		ActionStd<CounparInfo> select = new ActionStdCommom<CounparInfo>(option, CounparVisiDaoSelect.class);
		ActionLazy<CounparInfo> mergePayPartner = new ActionLazyCommom<CounparInfo>(option, CounparVisiMergePaypar.class);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
