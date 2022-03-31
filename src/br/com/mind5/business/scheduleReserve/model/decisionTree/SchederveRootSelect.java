package br.com.mind5.business.scheduleReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.model.action.SchederveVisiMergeToSelect;
import br.com.mind5.business.scheduleReserve.model.checker.SchederveCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SchederveRootSelect extends DeciTreeTemplateRead<SchederveInfo> {
	
	public SchederveRootSelect(DeciTreeOption<SchederveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchederveInfo> buildCheckerHook(DeciTreeOption<SchederveInfo> option) {
		List<ModelChecker<SchederveInfo>> queue = new ArrayList<>();		
		ModelChecker<SchederveInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchederveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchederveInfo>> buildActionsOnPassedHook(DeciTreeOption<SchederveInfo> option) {
		List<ActionStd<SchederveInfo>> actions = new ArrayList<>();	
		
		ActionStd<SchederveInfo> select = new ActionStdCommom<SchederveInfo>(option, SchederveVisiMergeToSelect.class);

		actions.add(select);			
		return actions;
	}
}
