package yuma140902.kettenkradmod.proxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
	public void registerEventHandlers() {
		super.registerEventHandlers();
		//MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);
	}
	
	@Override
	public void registerRenderers() {
		super.registerRenderers();
		//RenderingRegistry.registerEntityRenderingHandler(EntityBoatAcacia.class, new RenderModBoat(Type.ACACIA));
	}
}
