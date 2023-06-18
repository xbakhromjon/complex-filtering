package uz.bakhromjon.config;

import net.kaczmarzyk.spring.data.jpa.nativeimage.SpecificationArgumentResolverProxyHintRegistrar;

public class MyProjectSpecificationArgumentResolverProxyHintRegistrar extends SpecificationArgumentResolverProxyHintRegistrar {
	private MyProjectSpecificationArgumentResolverProxyHintRegistrar() {
		super("uz.bakhromjon");
	}
}
