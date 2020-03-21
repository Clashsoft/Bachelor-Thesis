abstract org.fulib.scenarios.ast.Node {
	// ...
	ScenarioFile(name: String, scenarios: [String:Scenario])

	Positioned {
		Scenario(file: ScenarioFile, name: String, body: SentenceList)
		// ...

		abstract decl.Name(readonly value: String) {
			UnresolvedName(value: String, text: String)
			// ...
		}

		abstract type.Type {
			UnresolvedType(name: String)
			// ...
		}

		abstract sentence.Sentence {
			SentenceList(items: [Sentence])
			ThereSentence(descriptor: MultiDescriptor)
			// ...
		}
	}

	// Helpers
	MultiDescriptor(type: Type, names: [Name], attributes: [NamedExpr])
	NamedExpr(name: Name, expr: Expr)
}
