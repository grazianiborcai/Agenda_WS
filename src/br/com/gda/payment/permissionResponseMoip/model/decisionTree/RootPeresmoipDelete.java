package br.com.gda.payment.permissionResponseMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionResponseMoip.model.action.StdPeresmoipDelete;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckExist;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckLangu;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckWrite;

public final class RootPeresmoipDelete extends DeciTreeWriteTemplate<PeresmoipInfo> {
	
	public RootPeresmoipDelete(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();	
		checker = new PeresmoipCheckWrite();
		queue.add(checker);		
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PeresmoipCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PeresmoipCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<PeresmoipInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<PeresmoipInfo> delete = new StdPeresmoipDelete(option);
		
		actions.add(delete);
		return actions;		
	}
}
