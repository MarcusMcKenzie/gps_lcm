%plotting moving start end tree near ISEC

%load('gps_moving_start_end_tree_near ISEC')


ix = data(1,5);      %initial point
Mx = mean(data(1:608,5));
Px = (Mx - (data(1:608,5)))  ; %Path from start


iy = data(1,6);       %initial point
My = mean(data(1:608,6));
Py = (My - (data(1:608,6))); %Path from start

iz = data(1,4);       %initial point
Mz = mean(data(1:608,4));
Pz =round( (Mz - (data(1:608,4))),3, 'significant'); %Path from start

%313
%figure(2)
%plot(.5*(Px),Py)

%plot(.5*(data(1:313,5)),(data(1:313,6)))

%V = var(data(1:313,6))


%axis([-140 40 -20 160])
%axis([-20 10 -15 15])
%axis([0 300 -300 0])
