package br.com.mind5.masterData.movimentType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.action.MamovypeVisiDaoSelect;
import br.com.mind5.masterData.movimentType.model.checker.MamovypeCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MamovypeRootSelect extends DeciTreeTemplateRead<MamovypeInfo> {
	
	public MamovypeRootSelect(DeciTreeOption<MamovypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MamovypeInfo> buildCheckerHook(DeciTreeOption<MamovypeInfo> option) {
		List<ModelChecker<MamovypeInfo>> queue = new ArrayList<>();		
		ModelChecker<MamovypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MamovypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<MamovypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MamovypeInfo> option) {
		List<ActionStd<MamovypeInfo>> actions = new ArrayList<>();
		
		ActionStd<MamovypeInfo> select = new ActionStdCommom<MamovypeInfo>(option, MamovypeVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
