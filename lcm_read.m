% add the lcm.jar file to the matlabpath - need to only do this once
javaaddpath /home/marcus/eece-5554/Lab1/my_types.jar 
javaaddpath /usr/local/share/java/lcm.jar


% Let’s assume the logging file is lcm-l.03 in the dir below
% open log file for reading

log_file = lcm.logging.Log('/home/marcus/eece-5554/Lab1/matlab_plots/gpsData_10min_static_ISEC.mat', 'r'); 
%log_file = lcm.logging.Log('/home/marcus/my_robot/log/lcm-log-2019-02-26-12:44:58', 'r'); 

% now read the file 
% here we are assuming that the channel we are interested in is RDI. Your channel 
% name will be different - something to do with GPS
% also RDI has fields altitude and ranges - GPS will probably have lat, lon, utmx,
% utmy etc

     
i=1;

data = single(zeros(1000, 6));

while true
 try
   ev = log_file.readNext();
   
   % channel name is in ev.channel
   % there may be multiple channels but in this case you are only interested in RDI channel
   if strcmp(ev.channel, 'GPS')
 
     % build gps object from data in this record
      gps = gps_lcm.gps_t(ev.data);

      % now you can do things like depending upon the rdi_t struct that was defined
    
	
	data(i,1) = gps.time; % (timestamp in microseconds since the epoch)
	data(i,2) = gps.latitude;
    data(i,3) = gps.longitude;
    data(i,4) = gps.altitude;
	data(i,5) = gps.easting;
	data(i,6) = gps.northing;
    
    i=i+1;
    
   
    end
  catch err   % exception will be thrown when you hit end of file
     break;
  end
end




% S = std(data(1:608,5))
% D = sqrt(data(1:608,5).^2 + data(1:608,6).^2)
% i = sqrt((6.72*10^5)^2 +(4.689256*10^6)^2)
% V = var(D)

