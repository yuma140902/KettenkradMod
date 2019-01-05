package yuma140902.kettenkradmod.proxy;

public class CommonProxy {
	public void registerEventHandlers() {
		//MinecraftForge.EVENT_BUS.register(CommonEventHandler.INSTANCE);
	}
	
	private int id = 0;
	public void registerEntities() {
		//EntityRegistry.registerModEntity(EntityBoatAcacia.class, "boat_acacia", id++, ModUpToDateMod.INSTANCE, 128, 5, true);
	}
	
	public void registerRenderers() { }
}
