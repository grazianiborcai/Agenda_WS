package br.com.mind5.masterData.fileDocType.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.fileDocType.info.FidoceInfo;
import br.com.mind5.masterData.fileDocType.model.action.StdFidoceDaoSelect;
import br.com.mind5.masterData.fileDocType.model.checker.FidoceCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFidoceSelect extends DeciTreeTemplateRead<FidoceInfo> {
	
	public RootFidoceSelect(DeciTreeOption<FidoceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FidoceInfo> buildCheckerHook(DeciTreeOption<FidoceInfo> option) {
		List<ModelChecker<FidoceInfo>> queue = new ArrayList<>();		
		ModelChecker<FidoceInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FidoceCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FidoceInfo>> buildActionsOnPassedHook(DeciTreeOption<FidoceInfo> option) {
		List<ActionStd<FidoceInfo>> actions = new ArrayList<>();
		
		ActionStd<FidoceInfo> select = new StdFidoceDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
