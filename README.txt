Hello, I made this project so that you can use Mc VR API mod that integrates with Vivecraft with Figura, please note this is highly experimental and may have any bugs, should you find any, please create a new Issue and I shall see what I can do.
IN ADDITION, docs are coming Soon :tm:, after the initial testing phase where I work out any major bugs.

So what does this mod do?
Features:
- Data for Headset, Left Controller, and Right Controller

Functions:
'type' is what type of data, 'left_controller'. 'right_controller', and 'headset'
- Uses the new "vr" global, currently only supports host player
	vr:isPlayerVr() : bool
	vr:getLookingAngle(String type) : Vec3
	vr:getPitch(String type) : float
	vr:getYaw(String type) : float
	vr:getRoll(String type) : float
	vr:getPosition(String type) : Vec3
	vr:getRotationMatrix(String type) : Matrix4f

Warning!
- I have not gotten the chance to test this in VR yet, only non-vr mode on vivecraft, so please keep in mind this may be buggy currently