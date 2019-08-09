package br.com.gda.payment.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.partnerMoip.permissionMoip.model.action.StdPeresmoipMergeToSelect;
import br.com.gda.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckLangu;
import br.com.gda.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckOwner;
import br.com.gda.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckRead;

public final class RootPeresmoipSelect extends DeciTreeReadTemplate<PeresmoipInfo> {
	
	public RootPeresmoipSelect(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PeresmoipCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PeresmoipCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PeresmoipCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<PeresmoipInfo> select = new StdPeresmoipMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
